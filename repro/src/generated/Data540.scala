package generated

final case class Data540(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data540 = copy(name = name.toUpperCase)
  def scale(k: Double): Data540 = copy(value = value * k)
  def addTag(t: String): Data540 = copy(tags = t :: tags)
  def put(k: String, v: String): Data540 = copy(meta = meta.updated(k, v))
  def merge(other: Data540): Data540 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data540 {
  given Ordering[Data540] = Ordering.by(_.id)
  def empty: Data540 = Data540(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data540 =
    Data540(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data540] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
