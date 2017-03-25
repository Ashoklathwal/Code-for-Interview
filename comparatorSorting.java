// Write your Checker class
class Checker implements Comparator<Player>
    {
     public int compare(Player a, Player b)
         {
          // if both player having same score
          if(a.score == b.score)
              // sort alphabatecally
              return a.name.compareTo(b.name);
           // else sort in decreasing order
     return ((Integer) b.score).compareTo(a.score);
         }
      
    }
    
 /*class Checker implements Comparator<Player>{

        public int compare(Player a, Player b) {
            // If 2 Players have the same score
            if(a.score == b.score){
                // Order alphabetically by name
                return a.name.compareTo(b.name);
            }    

            // Otherwise, order higher score first  
            return ((Integer) b.score).compareTo(a.score);
        }
    }
 */