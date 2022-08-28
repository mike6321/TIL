package com.example.java.multi_thread.book.section03_object_sharing;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class VolatileCachedFactorizer extends GenericServlet implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
    }

    private BigInteger extractFromRequest(ServletRequest request) {
        return new BigInteger("7");
    }

    private BigInteger[] factor(BigInteger i ) {
        return new BigInteger[] {i};
    }

    class OneValueCache {

        private final BigInteger lastNumber;
        private final BigInteger[] lastFactors;

        public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
            this.lastNumber = lastNumber;
            this.lastFactors = lastFactors;
        }

        public BigInteger[] getFactors(BigInteger i) {
            if (lastNumber == null || !lastNumber.equals(i)) {
                return null;
            } else {
                return Arrays.copyOf(lastFactors, lastFactors.length);
            }
        }
    }

}
