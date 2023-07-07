import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    private int base;
    private int perpendicular;
    private int hypotenuse;

    public PythagoreanTriplet(int base, int perpendicular, int hypotenuse) {
        this.base = base;
        this.perpendicular = perpendicular;
        this.hypotenuse = hypotenuse;
    }

    public String toString() {
        return String.format("(%d, %d, %d)", base, perpendicular, hypotenuse);
    }
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        } else if ( o instanceof PythagoreanTriplet ) {
            PythagoreanTriplet pt = (PythagoreanTriplet) o;
            return base == pt.base && perpendicular == pt.perpendicular && hypotenuse == pt.hypotenuse;
        } else {
            return false;
        }
    }

    public static PythagoreanTripletList makeTripletsList(){
            return new PythagoreanTripletList();
        }

    public static class PythagoreanTripletList{
        private Integer factor = null;
        private int sum;
        private static final double perimeterLimit = 1 + 1 + Math.sqrt(2);

        public PythagoreanTripletList withFactorsLessThanOrEqualTo(int limit)
        {
            factor = limit;
            return this;
        }

        public PythagoreanTripletList thatSumTo(int sum)
        {
            this.sum = sum;
            if(factor == null) {
                factor = sum;
            }
            return this;
        }

        public List<PythagoreanTriplet> build()
        {
            List<PythagoreanTriplet> triplets = new ArrayList<PythagoreanTriplet>();
            for(int a = 1; a <= Math.floor(sum/perimeterLimit) ; ++a)
            {
                int numerator = (a*a) + (int)Math.pow(sum-a,2);
                int denominator = 2 * (sum-a);

                if(numerator % denominator == 0) {
                    int c = numerator / denominator;
                    if (c <= factor) {
                        int b = sum - a - c;
                        triplets.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return triplets;
        }
    }
}


