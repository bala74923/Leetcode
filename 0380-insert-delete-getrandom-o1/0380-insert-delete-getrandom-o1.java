class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;
    public RandomizedSet() {
        set= new HashSet<>();
        list= new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.add(val)) {
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            // remove it from list
            int lind = list.indexOf(val);
            int temp = list.get(list.size()-1);
            list.set(list.size()-1,val);
            list.set(lind,temp);
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int ind = new Random().nextInt(0,list.size());
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */