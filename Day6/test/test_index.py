import pytest

def inc(x):
    return x + 1

@pytest.mark.parametrize("input,expected", [
    (3, 4),
    (0, 1),
    (-1, 0),
    (100, 101),
])
def test_answer(input, expected):
    assert inc(input) == expected