import unittest 
from solution import delinter 
class Test(unittest.Testcase):
  def test_delinter_should_return_the_notice(self):
    self.assertEqual(delinter("Could You guys sanity check my method?"), "<0> Consider replacing 'You guys' with 'you' or 'you all' or 'y'all'. Reference https://www.inclusive­styleguide.com/you-guys for details.\n<15> Consider replacing 'sanity check' with 'quick check' or 'confidence check' or 'coherence check'. Reference https://www.inclusive­styleguide.com/sanity-check for details.") 
    self.assertEqual(delinter("I' ve inserted a dummy value in the block below."), "<16> Consider replacing 'dummy value' with 'placeholder value' or 'sample value'. Reference https://www.inclusive-styleguide.com/dummy-value for details.") 
    self.assertEqual(delinter("This feature is estimated to require 600 engineer hours."), "")
    self.assertEqual(delinter("I' ve inserted a dummy value in the block below."), "<16> Consider replacing 'dummy value' with 'placeholder value' or 'sample value'. Reference https://www.inclusive-styleguide.com/dummy-value for details.") 
    self.assertEqual(delinter("Could you guys sanity check my method?"), "<6> Consider replacing 'you guys' with 'you' or 'you all' or 'y'all'. Reference https://www.inclusive­styleguide.com/you-guys for details.\n<15> Consider replacing 'sanity check' with 'quick check' or 'confidence check' or 'coherence check'. Reference https://www.inclusive­styleguide.com/sanity-check for details.") 
