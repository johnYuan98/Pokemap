package edu.frostburg.cosc310.projects.hashmap;

public class HashTable {
	private DataItem[] hashArray;//Array for storing data
	private int arraySize;//Actual number of elements
	private static final float LOAD_FACTOR = 0.7f;//Loading factor
	private static final float MAX_LOAD_FACTOR = 0.8f;
	
    /**
     * Number of hash table indexes
     */
    private int use = 0;
    
    //Constructor
	public HashTable(int size) { 
		arraySize = size;  
		hashArray = new DataItem[arraySize];
	}  
	  
	//print hash table
	public void displayTable(){  
		System.out.print("Hash Table: ");  
		for(int j=0; j<arraySize; j++){  
			if(hashArray[j] != null)  
	            System.out.println(hashArray[j].toString());  
	        else  
	            System.out.println("** ");  
	    }
		System.out.println("print finish");
	}
	  
	//hash function 
	public int hashFunc(String key){
		return key.equals("") ? 0 : key.hashCode() % arraySize;
	}

	/*
	 * Insert data into hash table
	 * 
	 * @param item
	 */
	public boolean insert(DataItem item){
		//Get key value of data
		String key = item.getName();
		//Calculate its hash value
		int hashVal = hashFunc(key);
		if(hashVal<0) {
			hashVal=-hashVal;
		}                               
	    while(hashArray[hashVal] != null){  
	         ++hashVal;//The insertion position is occupied, and the next position is detected linearly
	    }
	    hashArray[hashVal] = item;//Insert when space is found 
        use++;
         //Dynamic capacity expansion
         if(use>=hashArray.length * LOAD_FACTOR) {
        	 resize();
         }
         if(use>=hashArray.length * MAX_LOAD_FACTOR) {
        	 return false;
         }
	     return true;
	}
	
	/**
     * Capacity expansion
     */
    private void resize() {
    	DataItem[] oldTable = hashArray;
    	hashArray = new DataItem[hashArray.length * 2];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null) {
                continue;
            }
            hashArray[i]=oldTable[i];
        }
    }
    
	/*
	 * Delete in hash table
	 * 
	 * @param key
	 * @return boolean
	 */
	public boolean delete(String key) {  
		int hashVal = hashFunc(key);  //Calculate its hash value   
	  
		while(hashArray[hashVal] != null){                               
			if(hashArray[hashVal].getName().equals(key)){ 
				hashArray[hashVal]=hashArray[hashVal+1];
				arraySize--;
				use--;
				return true;
			}  
			++hashVal;  // Find next unit  
			hashVal %= arraySize;      
		}  
		return false;    // No data found to delete  
	}   
	  
	/*
	 *   Find in hash table
	 * 
	 *   @param key
	 *   @return DataItem
	 */
	public DataItem find(String key) {  
		int hashVal = hashFunc(key);  //Calculate its hash value  
		if(hashVal<0) {
			hashVal=-hashVal;
		}
		while(hashArray[hashVal] != null) { // Until empty cell                       
			if(hashArray[hashVal].getName().equals(key))  
				return hashArray[hashVal];   // find  
			++hashVal;                 // Go to the next unit  
	        hashVal %= arraySize;      // Do not exceed the size of the array  
	    }  
		return null;  // no find  
	}
	
	/*
	 * get hash table length
	 */
	public int getArraySize() {
		return arraySize;
	}
	
	public float returnLoadFactor() {
		return LOAD_FACTOR;
	}
}
