package constraints.subset;

import java.util.HashSet;
import java.util.Set;

public class Superset {

    private Set<Subset> subsets;

    public Superset() {
        subsets = new HashSet<>();
    }

    public void addSubset(Subset subset) {
        if (subset != null) {
            // Check if the subset association already exists in the superset
            if (subsets.contains(subset)) {
                throw new IllegalArgumentException("Subset association already exists in the superset.");
            }
            subsets.add(subset);

            // Update the back reference in the subset
            subset.setSuperset(this);
        }
    }

    public void removeSubset(Subset subset) {
        if (subset != null) {
            // Check if the subset association exists in the superset
            if (!subsets.contains(subset)) {
                throw new IllegalArgumentException("Subset association does not exist in the superset.");
            }
            subsets.remove(subset);

            // Update the back reference in the subset
            subset.setSuperset(null);
        }
    }
}

class Subset {
    private Superset superset;

    public void setSuperset(Superset superset) {
        if (this.superset != null && superset != null && !this.superset.equals(superset)) {
            throw new IllegalArgumentException("Subset association already exists with a different superset.");
        }
        this.superset = superset;
    }

    // Other subset-specific methods...

}
