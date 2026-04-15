package generated

final case class Data697(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data697 = copy(name = name.toUpperCase)
  def scale(k: Double): Data697 = copy(value = value * k)
  def addTag(t: String): Data697 = copy(tags = t :: tags)
  def put(k: String, v: String): Data697 = copy(meta = meta.updated(k, v))
  def merge(other: Data697): Data697 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data697 {
  given Ordering[Data697] = Ordering.by(_.id)
  def empty: Data697 = Data697(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data697 =
    Data697(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data697] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
