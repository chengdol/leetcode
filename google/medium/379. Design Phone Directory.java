// medium

/*
Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

*/

class PhoneDirectory {

    private Queue<Integer> unused;
    private Set<Integer> used;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers)
    {
        used = new HashSet<>();

        unused = new ArrayDeque<>();
        for (int i = 0; i < maxNumbers; i++) { unused.offer(i); }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get()
    {
        if (unused.isEmpty()) { return -1; }

        int number = unused.poll();
        used.add(number);
        return number;
    }

    /** Check if a number is available or not. */
    public boolean check(int number)
    {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number)
    {
        if (!used.contains(number)) { return; }

        used.remove(number);
        unused.offer(number);
    }
}

