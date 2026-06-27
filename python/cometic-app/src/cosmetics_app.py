import mysql.connector
import random

def connect_db():
    try:
        conn = mysql.connector.connect(user='sabya', password='oracle',
                                   host='127.0.0.1', database='cosmetics')
    except mysql.connector.Error as err:
        print ("Error connecting to database")
        print("Something went wrong: {}".format(err))
        print ("Try again later!")
        exit()
    else:
        return conn
    
def close_db (cdb):
    cdb.close()

def return_main():
    choice=''
    choice = input("Press Enter to go back to main menu -> ")
    if not choice:
        return
    else:
        return
    
def show_menu ():
    choice = ''
    print("Welcome to QUBA Beauty")
    print ("------------------------------------")
    print ("Here are your options!")
    print ("------------------------------------")
    print ("1. Explore our cosmetics collection")
    print ("2. Search a product by product/brand name")
    print ("3. Place an order for your product")
    print ("4. Cancel an existing order")
    print ("5. Get details of an existing order")
    print ("Press 6 or Enter to quit Application")
    print()
    choice = input ("Enter your choice: -> ")
    if not choice:
        print ()
        print ("Bye, see you again")
        exit()
    if choice == '1':
        get_prod()
    elif choice == '2':
        get_prod_brn()
    elif choice == '3':
        place_order()
    elif choice == '4':
        cancel_order()
    elif choice == '5':
        get_order()
    elif choice == '6':
        print ()
        print ("Bye, see you again")
        return '6'
    else:
        print ()
        print ("Invalid choice!")

def get_prod():
    prod_rec = ()
    cnx = connect_db()
    csr = cnx.cursor()
    qry = ("select prod_id, prod_name, unit_price, stock, discount, brand_name from products")
    csr.execute(qry)
    prod_rec = csr.fetchall()
    print ()
    print ("            Here are the exlcusive Cosmectics collections from QUBA Beauty!    ")
    print ("            _______________________________________________________________")
    print ()
    for prec in prod_rec:
        print(" Product ID:", prec[0], "Product Name:", prec[1], "Price:", prec[2], "Stock: ", prec[3], \
                        "Discount:", "{:.0%}".format(prec[4]/100), "Brand Name:", prec[5])
    print()
    close_db (cnx) 
    return_main()
   
def get_prod_brn():
    cnx = connect_db()
    iprd_name = ''
    ibrn_name = ''
    pbrnrec = ()
    iprd_name = input("Enter Product name: ")
    ibrn_name = input("Enter Brand name: ")
    if not iprd_name and not ibrn_name:
        print ("Product Name and Brand Name are blank!")
    else:
        csr = cnx.cursor()
        csr.execute("select prod_id, prod_name, unit_price, stock, discount, brand_name from products where prod_name = '{}' or brand_name = '{}'".format(iprd_name, ibrn_name))
        pbrnrec = csr.fetchall()
        if csr.rowcount <=0:
            print ("Product/Brand not found!")
        else:
            print ()
            print ("            Here are the Products matched your search criteria from QUBA Beauty!   ")
            print ("            ____________________________________________________________________")
            print ()
            for pbrnc in pbrnrec:
                print(" Product ID:", pbrnc[0], "Product Name:", pbrnc[1], "Price:", pbrnc[2], "Stock:", pbrnc[3], \
                "Discount:", "{:.0%}".format(pbrnc[4]/100), "Brand Name:", pbrnc[5])
            print()
    close_db (cnx) 
    return_main()

def place_order():
    cnx = connect_db()
    oprd_rec = ()
    iprd_name = ''
    ibrn_name =''
    iqty = 0
    imob = ''
    icname = ''
    ipin = ''
    oord_id = 0
    ototp = 0
    odisc = 0
    oprod_id = ''
    ounitp = 0
    tdiscp = 0
    oqty = 0
    print ("All input fields are mandatory!")
    print("----------------------------------")
    iprd_name = input("Enter Product name: ")
    ibrn_name= input("Enter Brand name: ")
    iqty = input("Enter quantity: ")
    imob = input("Enter your mobile no: ")
    icname = input("Enter your name: ")
    ipin = input("Enter your Pin Code: ")

    if (not iprd_name) or (not ibrn_name) or (not iqty) or (not imob) or (not icname) or (not ipin) or \
        (not iqty.isnumeric()) or (int(iqty) <=0):
        print ("One of the mandatory fields is missing or invalid. Order cannot be placed")
        print()
        close_db (cnx) 
        return_main()
    else:
        csr = cnx.cursor()
        csr.execute("select prod_id, unit_price, discount from products where prod_name = '{}' and \
                    brand_name = '{}' and stock >= {}".format(iprd_name, ibrn_name, iqty))
        oprd_rec = csr.fetchone()
        if csr.rowcount <=0:
            print ("Product with the Brand you entered is either not available or out of stock")
            print()
            close_db (cnx) 
            return_main()
        else:
            oprod_id = oprd_rec [0]
            ounitp = oprd_rec [1]
            odisc = oprd_rec [2]
            oqty = int(iqty)
            ototp = ounitp * oqty
            oord_id = random.randint(1000, 9999)
            tdiscp = ototp * (odisc/100)
            ototp = ototp - tdiscp            

            try:
                csr.execute ("insert into orders (order_id, prod_id, tot_item, tot_price, cust_name, pin_code, mob_no) \
                            values({}, '{}', {}, {}, '{}', '{}', '{}')".format (oord_id, oprod_id, oqty, ototp, icname, ipin, imob))
                
                csr.execute ("update products set stock = stock - {} where prod_id = '{}'".format(oqty, oprod_id))
            except mysql.connector.Error as err:
                print ()
                print ("Error encountered while placing!")
                print("Something went wrong: {}".format(err))
                print ("Going back to Main Menu")
                print ()
                close_db (cnx)
                return
            else:
                ch = input("Confirm order? (Y/N): ")
                if ch == 'Y' or ch == 'y':
                    cnx.commit()
                    print("Your order is placed. Order ID: ", oord_id, " (Keep this Order ID for future reference!)")
                    print ("Discount applied: ", "{:.1%}".format(odisc/100))
                    print ("Total Price: ", ounitp * oqty)
                    print ("Price after discount: ", ototp)
                else:
                    cnx.rollback()
            close_db (cnx) 
            return_main()

def cancel_order():
    ord_rec = ()
    iord_id = 0
    ord_tot_item = 0
    ord_pid = ''
    cnx = connect_db()
    iord_id = int(input("Enter Order ID: "))
    csr = cnx.cursor()
    csr.execute ("select prod_id, tot_item from orders where order_id = {}".format (iord_id))
    ord_rec = csr.fetchone()
    if csr.rowcount <=0:
        print ("Order ID does not exist. Order cannot be cancelled")
        print()
        close_db(cnx)
        return_main()
    else:
        ord_pid= ord_rec [0]
        ord_tot_item = ord_rec [1]
        csr.execute ("delete from orders where order_id = {}".format (iord_id))
        csr.execute ("update products set stock = stock + {} where prod_id = '{}'".format(ord_tot_item, ord_pid))
        ch = input("Confirm order cancellation? (Y/N): ")
        if ch == 'Y' or ch == 'y':
            cnx.commit()
            print("Your order is cancelled. Order ID: ", iord_id)
        else:
            cnx.rollback()
    close_db(cnx)
    return_main()

def get_order():
    cnx = connect_db()
    iord_id = 0
    oord_rec = ()
    print ()
    iord_id = input("Enter Order ID: ")
    if not iord_id:
        print ("You entered blank Order ID! going back to Main Menu")
        print ()
        close_db(cnx)
        return
    else:
        csr = cnx.cursor()
        csr.execute ("select order_id, prod_id, tot_item, tot_price, cust_name, pin_code, mob_no \
                     from orders where order_id = {}".format (iord_id))
        oord_rec = csr.fetchall()
        if csr.rowcount <=0:
            print ("Order ID does not exist! going back to Main Menu")
            print ()
            close_db(cnx)
            return_main()
        else:
            for orec in oord_rec:
                print ("Order ID:", orec[0], "Product ID:", orec[1], "Unit Ordered:", orec[2], 
                        "Total Price: ", orec [3], "Customer Name:", orec[4], "Pin Code:", orec[5],
                        "Mobile No.", orec[6])
            print ()
            close_db(cnx)
            return_main()

ch = ' '
while ch != '6':
    ch = show_menu()
