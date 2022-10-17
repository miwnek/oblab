package agh.ics.oop;

public  enum MapDirection {
        NORTH, SOUTH, WEST, EAST;

        private String str;
        private MapDirection next;
        private MapDirection prev;
        private Vector2d vers;


        static {
            NORTH.next = EAST;
            SOUTH.next = WEST;
            EAST.next = SOUTH;
            WEST.next = NORTH;

            NORTH.prev = WEST;
            SOUTH.prev = EAST;
            EAST.prev = NORTH;
            WEST.prev = SOUTH;

            NORTH.vers = new Vector2d(0, 1);
            SOUTH.vers = new Vector2d(0, -1);
            EAST.vers = new Vector2d(1, 0);
            WEST.vers = new Vector2d(-1, 0);

            NORTH.str = "Północ";
            SOUTH.str = "Południe";
            EAST.str = "Wschód";
            WEST.str = "Zachód";

        }

        public String toString() {
            return str;
        }

        public MapDirection next() {
            return next;
        }

        public MapDirection previous() {
            return prev;
        }

        public Vector2d toUnitVector() {
            return vers;
        }
    }

