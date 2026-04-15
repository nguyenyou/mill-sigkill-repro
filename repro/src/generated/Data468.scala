package generated

final case class Data468(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data468 = copy(name = name.toUpperCase)
  def scale(k: Double): Data468 = copy(value = value * k)
  def addTag(t: String): Data468 = copy(tags = t :: tags)
  def put(k: String, v: String): Data468 = copy(meta = meta.updated(k, v))
  def merge(other: Data468): Data468 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data468 {
  given Ordering[Data468] = Ordering.by(_.id)
  def empty: Data468 = Data468(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data468 =
    Data468(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data468] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
