package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HotelBookingsPossible {
    public static void main(String[] args) {
        ArrayList<Integer> arrive=new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> depart=new ArrayList<>(Arrays.asList(2, 6, 8));
        int K=1;
        System.out.print(hotel(arrive,depart,K));
    }
    private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        List<BookingInfo> bookings=arrive.stream()
                .map(a->new BookingInfo(a,'A'))
                .collect(Collectors.toList());

        bookings.addAll(
                depart.stream()
                        .map(d->new BookingInfo(d,'D'))
                        .collect(Collectors.toList())
        );
        Collections.sort(bookings);

        int maxBookings=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<bookings.size();i++){
            BookingInfo booking=bookings.get(i);
            if('A'==booking.getType()){
                count++;
                maxBookings=Math.max(maxBookings,count);
            }
            else count--;
        }
        return maxBookings<=K;
    }
    private static class BookingInfo implements Comparable<BookingInfo>{
        private int date;
        private char type;

        public BookingInfo(int date, char type) {
            this.date = date;
            this.type = type;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }

        @Override
        public int compareTo(BookingInfo o) {
            if(this.date>o.date || (this.date==o.date && this.type>o.type))
                return 1;
            else if(this.date==o.date && this.type==o.type)
                return 0;
            else
                return -1;
        }
    }
}
