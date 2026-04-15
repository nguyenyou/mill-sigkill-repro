package generated

final case class Data460(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data460 = copy(name = name.toUpperCase)
  def scale(k: Double): Data460 = copy(value = value * k)
  def addTag(t: String): Data460 = copy(tags = t :: tags)
  def put(k: String, v: String): Data460 = copy(meta = meta.updated(k, v))
  def merge(other: Data460): Data460 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data460 {
  given Ordering[Data460] = Ordering.by(_.id)
  def empty: Data460 = Data460(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data460 =
    Data460(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data460] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
