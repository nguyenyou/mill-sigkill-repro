package generated

final case class Data989(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data989 = copy(name = name.toUpperCase)
  def scale(k: Double): Data989 = copy(value = value * k)
  def addTag(t: String): Data989 = copy(tags = t :: tags)
  def put(k: String, v: String): Data989 = copy(meta = meta.updated(k, v))
  def merge(other: Data989): Data989 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data989 {
  given Ordering[Data989] = Ordering.by(_.id)
  def empty: Data989 = Data989(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data989 =
    Data989(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data989] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
