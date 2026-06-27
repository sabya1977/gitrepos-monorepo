package com.corejava.Oops.Records;

record Member (int meme_ck, String meme_name, String meme_sfx, int meme_age, String meme_sex, int sbsb_ck) {
        // Records can have custom constructors with validation
        public Member {
            if (meme_age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }

            if (meme_name == null || meme_name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            if (meme_ck == 0) {
                throw new IllegalArgumentException("MEME_CK cannot be zero");
            }

            if (sbsb_ck == 0) {
                throw new IllegalArgumentException("SBSB_CK cannot be zero");
            }

            if (meme_sfx.isEmpty()) {
                throw new IllegalArgumentException("MEME_SFX cannot be empty");
            }
        }

        // Records can have additional methods
        public boolean isAdult () {
            return this.meme_age >=18;
        }

        public String getDisplayName () {
            return meme_name.toUpperCase();
        }

        public int meme_ck() { return this.meme_ck;}

        public static void main(String[] args) {
            System.out.println("=== Java Records Examples ===\n");
            Member mbrObj1 = new Member (18922, "John Doe", "01", 28, "M", 18922);
            if (mbrObj1.isAdult()) {
                System.out.println(mbrObj1.getDisplayName() + " is adult");
            } else { System.out.println(mbrObj1.getDisplayName() + " is not adult"); }

            System.out.println(mbrObj1);

            // this statement will fail
            Member mbrObj2 = new Member (190988, "Jane Smith", "01", 40, "M", 18922);            

            if (mbrObj2.isAdult()) {
                System.out.println(mbrObj1.getDisplayName() + " is adult");
            } else { System.out.println(mbrObj1.getDisplayName() + " is not adult"); }
        }
    }


