package generated

final case class Data674(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data674 = copy(name = name.toUpperCase)
  def scale(k: Double): Data674 = copy(value = value * k)
  def addTag(t: String): Data674 = copy(tags = t :: tags)
  def put(k: String, v: String): Data674 = copy(meta = meta.updated(k, v))
  def merge(other: Data674): Data674 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data674 {
  given Ordering[Data674] = Ordering.by(_.id)
  def empty: Data674 = Data674(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data674 =
    Data674(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data674] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
