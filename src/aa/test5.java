package aa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test5 {
    public static void main(String[] args) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        ArrayList<Interval> arrayList = new ArrayList<>();
        arrayList.add(i1);
        arrayList.add(i2);
        arrayList.add(i3);
        arrayList.add(i4);
        ArrayList<Interval> res = merge(arrayList);
        for (Interval i : res)
            System.out.println(i.start+" "+i.end);
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            Interval next = intervals.get(i);
            Interval last = res.get(res.size()-1);
            if(last.end >= next.start){
                last.end = Math.max(last.end, next.end);
                res.remove(res.size()-1);
                res.add(last);
            }else{
                res.add(next);
            }
        }
        return res;
    }
}
class Interval{
    int start;
    int end;
    Interval(int s, int e){
        start = s;
        end = e;
    }
}