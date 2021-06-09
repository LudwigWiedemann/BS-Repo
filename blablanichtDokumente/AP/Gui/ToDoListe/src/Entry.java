class Entry {
    private final String item;
    private final int count;

    public Entry(String item, int count) {
        this.item = item;
        this.count = count;
    }

    public Entry(String lineInFile) {
        String[] splitLine = lineInFile.split(" ");
        item = splitLine[0].trim();
        count = Integer.parseInt(splitLine[splitLine.length - 1].trim());
    }

    @Override
    public String toString() {
        return item + "          " + count;
    }
}
