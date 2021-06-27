# PromotionEngine

The problem
-------------

We need you to implement a simple promotion engine for a checkout process. Our Cart contains a list of single character SKU ids (A, B, C.	) over which the promotion engine will need to run.
The promotion engine will need to calculate the total order value after applying the 2 promotion types
•	buy 'n' items of a SKU for a fixed price (3 A's for 130)
•	buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 )
The promotion engine should be modular to allow for more promotion types to be added at a later date (e.g. a future promotion could be x% of a SKU unit price). For this coding exercise you can assume that the promotions will be mutually exclusive; in other words if one is applied the other promotions will not apply
Test Setup
Unit price for SKU IDs A	50
B	30
C	20
D	15

Active Promotions
3 of A's for 130
2 of B's for 45 C & D for 30

Scenario A
1	* A	50
1	* B	30
1	* C	20

Total		
100
Scenario	B	
5 * A		130 + 2*50
5 * B		45 + 45 + 30
1 * C		28

Total	370

Scenario C
3	* A	130
5	* B	45 + 45 + 1 * 30
1	* C	-
1	* D	30




Solution
---------

The Spring boot project has two endpoints:

-purcharseOrder (POST): to create order. Returns the total amount of the order

-updatePromotions (POST): to update the promotions. Returns nothing




Example of purcharseOrder request:
    
   {
    "orders": [
        {
            "idProduct": "A",
            "quantity": 5
        },
        {
            "idProduct": "B",
            "quantity": 5
        },
        {
            "idProduct": "C",
            "quantity": 1
        }
    ]
}

Example of updatePromotions request:

{
	"promotions":[
		{
			"id": "1",
			"unitOrder":[
				{
					"idProduct":"A",
					"quantity": 3
				}
			],
			"promotionPrice": 100
		},
		{
			"id": "2",
			"unitOrder":[
				{
					"idProduct":"B",
					"quantity": 2
				}
			],
			"promotionPrice": 45		
		},
		{
			"id": "3",
			"unitOrder":[
				{
					"idProduct":"C",
					"quantity": 1
				},
				{
					"idProduct":"D",
					"quantity": 1
				}				
			],
			"promotionPrice": 25		
		}
	
	]
	
}




