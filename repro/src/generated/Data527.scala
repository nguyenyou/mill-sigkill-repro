package generated

final case class Data527(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data527 = copy(name = name.toUpperCase)
  def scale(k: Double): Data527 = copy(value = value * k)
  def addTag(t: String): Data527 = copy(tags = t :: tags)
  def put(k: String, v: String): Data527 = copy(meta = meta.updated(k, v))
  def merge(other: Data527): Data527 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data527 {
  given Ordering[Data527] = Ordering.by(_.id)
  def empty: Data527 = Data527(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data527 =
    Data527(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data527] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
