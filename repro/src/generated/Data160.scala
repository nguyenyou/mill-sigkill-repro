package generated

final case class Data160(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data160 = copy(name = name.toUpperCase)
  def scale(k: Double): Data160 = copy(value = value * k)
  def addTag(t: String): Data160 = copy(tags = t :: tags)
  def put(k: String, v: String): Data160 = copy(meta = meta.updated(k, v))
  def merge(other: Data160): Data160 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data160 {
  given Ordering[Data160] = Ordering.by(_.id)
  def empty: Data160 = Data160(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data160 =
    Data160(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data160] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
