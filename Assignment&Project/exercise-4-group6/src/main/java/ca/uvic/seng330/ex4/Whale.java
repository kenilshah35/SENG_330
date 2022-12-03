package ca.uvic.seng330.ex4;

public class Whale
{
    public enum WhaleSpecies {
        SPERM_WHALE,
        BEAKED_WHALE,
        HUMPBACK_WHALE,
        GREY_WHALE,
        MINKE_WHALE,
        FIN_WHALE,
        BLUE_WHALE,
        RIGHT_WHALE,
        SEI_WHALE,
        KILLER_WHALE,
        FALSE_KILLER_WHALE,
        COMMON_DOLPHIN,
        PACIFIC_WHITE_SIDED_DOLPHIN,
        RISSOS_DOLPHIN,
        HARBOUR_PORPOISE,
        DALLS_PORPOISE
    }

    public enum Status {
        UNDISCOVERED,
        SPOTTED,
        DEAD
    }

    static class InvalidStatusException extends RuntimeException {
        public InvalidStatusException(String msg) {
            super(msg);
        }
    }

    private final WhaleSpecies mSpecies;
    private final String mDescription;
    private Status status = Status.UNDISCOVERED;

    public Whale(WhaleSpecies species, String description) {
        if (species == null) {
            throw new NullPointerException();
        }
        if( description == null ) {
            description = "";
        }
        mDescription = description;
        mSpecies = species;
    }

    public void spot() {
        if (this.status == Status.DEAD) return;
        this.status = Status.SPOTTED;
    }

    public void reportDead() throws InvalidStatusException {
        if (this.status == Status.DEAD) {
            throw new InvalidStatusException("Dead whales can not be reported dead twice");
        }
        this.status = Status.DEAD;
    }

    public WhaleSpecies getSpecies() {
        return mSpecies;
    }

    public String getDescription() {
        return mDescription;
    }

    public Status getStatus() {
        return status;
    }
}
