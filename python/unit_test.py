import unittest
import print_demo
from os import access


class TestDe(unittest.TestCase):
    def test_add(self):
        self.assertEqual(print_demo.add(1, 2), 3)

    def test_add2(self):
        self.assertEqual(print_demo.add(1, 2), 4)
    def test_add3(self):
        self.assertEqual(print_demo.add(1, -1), 0)
    def test_add4(self):
        self.assertEqual(print_demo.add(1, -1), 2)


if __name__ == '__nain__':
    unittest.main()
