# PromotionEngine

The Spring boot project has two endpoints:

purcharseOrder (POST): to create order. Returns the total amount of the order
updatePromotions (POST): to update the promotions. Returns nothing

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




