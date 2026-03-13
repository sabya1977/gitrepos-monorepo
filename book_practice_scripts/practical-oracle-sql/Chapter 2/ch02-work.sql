-- View brewery_products simply shows which beers are purchased from which
-- breweries. A product will be shown only once per brewery.
select *
  from practical.brewery_products;
--
-- View customer_order_products shows which products are 
-- included in each customer order. A product will be shown
-- once per order.
--
-- View customer_order_products shows which beers are sold to which customers, 
-- but also includes how much was sold and when, so a product can be shown multiple times
-- per customer.
--
select *
  from practical.customer_order_products;
--
--
select product_id as p_id,
       product_name
  from practical.customer_order_products
 where customer_id = 50741;
--
select product_id as p_id,
       product_name
  from practical.brewery_products
 where brewery_id = 523
 order by p_id;