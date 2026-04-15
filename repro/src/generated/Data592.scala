package generated

final case class Data592(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data592 = copy(name = name.toUpperCase)
  def scale(k: Double): Data592 = copy(value = value * k)
  def addTag(t: String): Data592 = copy(tags = t :: tags)
  def put(k: String, v: String): Data592 = copy(meta = meta.updated(k, v))
  def merge(other: Data592): Data592 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data592 {
  given Ordering[Data592] = Ordering.by(_.id)
  def empty: Data592 = Data592(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data592 =
    Data592(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data592] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
