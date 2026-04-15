package generated

final case class Data706(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data706 = copy(name = name.toUpperCase)
  def scale(k: Double): Data706 = copy(value = value * k)
  def addTag(t: String): Data706 = copy(tags = t :: tags)
  def put(k: String, v: String): Data706 = copy(meta = meta.updated(k, v))
  def merge(other: Data706): Data706 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data706 {
  given Ordering[Data706] = Ordering.by(_.id)
  def empty: Data706 = Data706(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data706 =
    Data706(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data706] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
