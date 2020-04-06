import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class TestDenis {
    private class Hits implements Comparable<Hits>{
        private String feature;
        private Long hits;
        public Hits(String feature, List<String> featureRequests){
            this.feature = feature;
            this.hits = countHits(feature, featureRequests);
        }
        private Long countHits(String feature, List<String> featureRequests){
            return featureRequests.parallelStream().filter(f -> f.toLowerCase().contains(feature.toLowerCase())).count();
        }
        @Override
        public int compareTo(Hits o) {
            if (o.feature.equalsIgnoreCase(this.feature)){
                return o.feature.toLowerCase().compareTo(this.feature.toLowerCase());
            }
            return o.hits.compareTo(this.hits);
        }
    }
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        // WRITE YOUR CODE HERE
        return possibleFeatures.parallelStream()
                .map(s -> new Hits(s, featureRequests))
                .sorted(Comparator.reverseOrder())
               // .peek(feature -> )
                .limit(topFeatures)
                .map(h -> h.feature)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void test(){
    }
}