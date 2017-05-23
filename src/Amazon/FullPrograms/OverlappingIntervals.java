package Amazon.FullPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhishek.ar on 23/05/17.
 * Given a collection of Intervals,merge all the overlapping Intervals.
 For example:
 Given [1,3], [2,6], [8,10], [15,18],

 return [1,6], [8,10], [15,18].

 Make sure the returned intervals are sorted.
 */

class Interval implements Comparable<Interval>{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    @Override
    public int compareTo(Interval o) {
        return this.end < o.end ? -1 : 1;
    }
}
/*
*
1) Sort all intervals in decreasing order of start time.
2) Traverse sorted intervals starting from first interval,
do following for every interval.
    a) If current interval is not first interval and it
    overlaps with previous interval, then merge it with
    previous interval. Keep doing it while the interval
    overlaps with the previous one.
    b) Else add current interval to output list of intervals.
*/

public class OverlappingIntervals {

    public static List<Interval> mergeIntervals(List<Interval> intervalList){
        List<Interval> finalResult = new ArrayList<Interval>();
        Collections.sort(intervalList);
        int index = 0;
        for(int i=0; i < intervalList.size(); ++i){
            if ( i!= 0){
                while( index > 0 && finalResult.get(index-1).getStart() <= intervalList.get(i).getEnd()){
                    finalResult.get(index-1).setStart(Math.min(finalResult.get(index-1).getStart(),intervalList.get(i).getStart()));
                    finalResult.get(index-1).setEnd(Math.max(finalResult.get(index-1).getEnd(),intervalList.get(i).getEnd()));
                    index--;
                }
            }else {
                finalResult.add(new Interval(intervalList.get(i).getStart(), intervalList.get(i).getEnd()));
            }
            index++;
        }
        return finalResult;
    }

    public static void main(String [] args){
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(6,8));
        intervals.add(new Interval(1,9));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(4,7));
        List<Interval> finList = mergeIntervals(intervals);
        for(Interval interval: finList){
            System.out.println(interval.getStart() + " " + interval.getEnd());
        }
    }
}
