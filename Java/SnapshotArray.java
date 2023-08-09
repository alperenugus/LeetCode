/*
Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */

class SnapshotArray {

    List<HashMap<Integer, Integer>> snaps;
    int currentSnap;

    public SnapshotArray(int length) {
        snaps = new ArrayList<>();
        for(int i = 0; i < length; i++) snaps.add(new HashMap<>());
        currentSnap = 0;
    }

    public void set(int index, int val) {
        snaps.get(index).put(currentSnap, val);
    }

    public int snap() {
        return currentSnap++;
    }

    public int get(int index, int snap_id) {
        if(index > snaps.size() || index < 0) return 0;

        HashMap<Integer, Integer> map = snaps.get(index);

        while(map.get(snap_id) == null){
            snap_id--;
            if(snap_id < 0) return 0;
        }

        return map.get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */