import pytest

def test_sum():
   x = 25
   y=2
   assert x + y == 27

def test_diff():
   x = 25
   y=2
   assert x - y == 23

@pytest.mark.activity
def test_mul():
   x = 25
   y=2
   assert x * y == 50

@pytest.mark.activity
def test_div():
   x = 25
   y= 5
   assert x/y == 5

