package tennis;

class Player {
    private final String name;

    Player(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Player) {
            Player that = (Player) other;
            return this.name.equals(that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    String getName() {
        return name;
    }
}
