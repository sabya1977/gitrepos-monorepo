import oracledb
sql = "SELECT first_name, last_name FROM hr.employees WHERE ROWNUM < 6"
with oracledb.connect(user="oradev23", password="oracle", dsn="localhost/freepdb1") as connection:
    with connection.cursor() as cursor:
        cursor.execute(sql)
        for first_name, last_name in cursor:
            print(f"{first_name} {last_name}")