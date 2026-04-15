package generated

final case class Data981(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data981 = copy(name = name.toUpperCase)
  def scale(k: Double): Data981 = copy(value = value * k)
  def addTag(t: String): Data981 = copy(tags = t :: tags)
  def put(k: String, v: String): Data981 = copy(meta = meta.updated(k, v))
  def merge(other: Data981): Data981 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data981 {
  given Ordering[Data981] = Ordering.by(_.id)
  def empty: Data981 = Data981(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data981 =
    Data981(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data981] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
