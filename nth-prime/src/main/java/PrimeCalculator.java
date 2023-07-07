class PrimeCalculator {

    boolean isPrime(int n)
    {
        for(int i = 2; i <= n/2; ++i)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    int nth(int nth) {
        if(nth < 1)
            throw new IllegalArgumentException();
        int st = 2, primeNo = 0, prime = -1;
        while(primeNo < nth)
        {
            if(isPrime(st))
            {
                ++primeNo;
                prime = st;
            }
            ++st;
        }
        return prime;
    }

}
