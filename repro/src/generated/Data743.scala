package generated

final case class Data743(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data743 = copy(name = name.toUpperCase)
  def scale(k: Double): Data743 = copy(value = value * k)
  def addTag(t: String): Data743 = copy(tags = t :: tags)
  def put(k: String, v: String): Data743 = copy(meta = meta.updated(k, v))
  def merge(other: Data743): Data743 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data743 {
  given Ordering[Data743] = Ordering.by(_.id)
  def empty: Data743 = Data743(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data743 =
    Data743(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data743] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
