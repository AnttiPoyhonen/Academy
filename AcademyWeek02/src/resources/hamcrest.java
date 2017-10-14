    // import static org.hamcrest.Matchers.*;
    // import static org.junit.Assert.*;


    /* 
    
    // Hamcrest, org.hamcrest.Matchers.*, .jar from the net
    
    @Test
    public void yksiHamcrestEqualTest() {
        assertThat("yksi", is(equalTo("yksi")));
    }
    
    @Test
    public void hamcrestGreaterThanTest() {
        assertThat(5, is(greaterThan(4)));
    }
    
    @Test
    public void hamcrestCloseToTest() {
        assertThat(0.1 + 0.2, is(closeTo(0.3, 0.000001)));
    }
    
    @Test
    public void hamcrestEqualToIgnoringCaseTest() {
        assertThat("sana", is(equalToIgnoringCase("SANA")));
    }
    
    @Test
    public void hamcrestHasItemTest() {
        assertThat(Arrays.asList(new Integer[]{2, 4, 6, 8, 10}), is(hasItem(10)));
    }


    */
    
    // Hamcrest Matchers
    
    // CORE (used to run Matchers inside assertThat methods as second parameter):
    // anything - always matches
    // describedAs - decorator to add custom failure
    // is - decorator to improve readability
    
    // LOGICAL (wrappers):
    // ALLoF - if all matchers match, short circuiting like &&
    // AnyOf - if one of matchers match, short circuiting like ||
    // not - matches if wrapped matcher does not match
    
    // OBJECT:
    // equalTo - object equality using .equals()
    // hasToString - testing Object.toString()
    // instanceOf, isCompatibleType - test object type
    // notNullValue, nullValue - test for null
    // sameInstance - test object identity / clone
    
    // BEANS:
    // hasProperty - test JavaBeans properties
    
    // COLLECTIONS:
    // array - test elements against an array of Matchers
    // hasEntry, hasKey, hasValue - testing a map for containing entry, key or value
    // hasItem, hasItems - test collection if contains
    // hasItemInArray - test array if contains
    
    // NUMBER:
    // closeTo - test floating point values (testable, accuracy)
    // greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo
    //      - test ordering
    
    // TEXT:
    // equalToIgnoringCase - test String equality ignoring case
    // equalToIgnoringWhiteSpace - test String equality ignoring whitespaces
    // containsString, endsWith, startsWith - test String matching