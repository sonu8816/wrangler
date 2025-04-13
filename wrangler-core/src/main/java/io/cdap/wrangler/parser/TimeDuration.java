public class TimeDuration extends Token {
   private final double value;
   private final String unit;
   public TimeDuration(String value) {
       super(value);
       this.unit = value.replaceAll("[0-9.]", "");
       this.value = Double.parseDouble(value.replaceAll("[^0-9.]", ""));
   }
   public long getMilliseconds() {
       switch (unit) {
           case "ms": return (long) value;
           case "s": return (long) (value * 1000);
           case "m": return (long) (value * 60 * 1000);
           case "h": return (long) (value * 60 * 60 * 1000);
           default: throw new IllegalArgumentException("Unknown unit");
       }
   }
}