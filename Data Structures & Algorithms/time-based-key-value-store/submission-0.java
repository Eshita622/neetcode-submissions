

class TimeMap {
    private final Map<String, List<Entry>> store;

    private static class Entry {
        final int timestamp;
        final String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>())
             .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = store.get(key);
        if (entries == null) return "";

        int lo = 0, hi = entries.size() - 1;
        String result = "";

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (entries.get(mid).timestamp <= timestamp) {
                result = entries.get(mid).value; 
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}