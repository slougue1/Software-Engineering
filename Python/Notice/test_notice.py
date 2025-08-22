import unittest 
from solution import notice 
class Test(unittest.TestCase): 
  def test_notice_should_return_a_notice_for_man_hours(self): 
  self.assertEqual(notice("man_hours",15,"woman hours"), "<15> Consider replacing 'woman hours' with 'person hours' or 'engineer hours'. Reference https://www.inclusive­styleguide.com/man-hours for details.") 
  self.assertEqual(notice("grandfathered",2,"grandfathered"), "<2> Consider replacing 'grandfathered' with 'legacy status'. Reference https://www.inclusive­styleguide.com/grandfathered for details.") 
  self.assertEqual(notice("sanity_check",4,"sanity check"), "<4> consider replacing 'sanity check' with 'quick check' or 'confidence check' or 'coherence check'. Reference https://www.inclusive-styleguide.com/sanity-check for details.") 
