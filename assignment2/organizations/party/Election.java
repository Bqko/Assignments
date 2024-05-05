package assignment2.organizations.party;

/**
 * Represents an election.
 */
public class Election {
    private int votersNumber;
    private boolean fair;
    private String description;

    public Election(int votersNumber, boolean fair, String description) {
        this.votersNumber = votersNumber;
        this.fair = fair;
        this.description = description;
    }

    // Getters and setters
    public int getVotersNumber() {
        return votersNumber;
    }

    public void setVotersNumber(int votersNumber) {
        this.votersNumber = votersNumber;
    }

    public boolean isFair() {
        return fair;
    }

    public void setFair(boolean fair) {
        this.fair = fair;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}