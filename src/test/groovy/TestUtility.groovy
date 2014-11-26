/**
 *
 * @author Robson_Farias
 */
class TestUtility {
    static userNameGenerator = { String alphabet, int n ->
        new Random().with {
            (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
        }
    }
}

