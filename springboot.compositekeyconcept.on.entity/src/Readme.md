# During the implementation of composte key must be implmented things

# equals() and hashCode() are mandatory for composite keys in JPA.
 # why ?

#  ------------------Reaons----------------------------------------------

 # 1. Entity Identity
       # When you use a composite key (@EmbeddedId or @IdClass), JPA needs to compare instances 
           # of the key to check if two objects represent the same database row.
         # In JPA/Hibernate, every entity instance is uniquely identified by its primary key.

             # If the primary key is composite (multiple fields), JPA needs a way to compare them.That’s where equals() comes in — it ensures that:

               # new Compositekey(1, 100).equals(new Compositekey(1, 100)) //  true
            # Without equals(), Java would use the default Object.equals(), which compares memory references — so even if orderId and productId are the same, they’d be treated as different objects.

# 2.  Collections and Caching
      Entities and IDs are often stored in:
       Sets (e.g., Set<Order> in persistence context)
      Maps (e.g., Hibernate caches entities using Map<Id, Entity>)

     For these data structures to work correctly, the key must implement hashCode() consistently with equals().
       Otherwise: JPA might insert duplicate rows in cache,Queries like findById() may fail because the lookup key doesn't match.
# ----------------------------------- Reason fininshed here-----------------------------------------------------------------------------

# IF you use controller and send payload in that case payload must look like for composite key
#   {
       "id": {
         "orderId": 101,
        "productId": 501
           },
         "orderName": "Mobile",
           "quantity": 2,
          "price": 15000
      }
