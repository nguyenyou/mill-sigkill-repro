package generated

final case class Data226(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data226 = copy(name = name.toUpperCase)
  def scale(k: Double): Data226 = copy(value = value * k)
  def addTag(t: String): Data226 = copy(tags = t :: tags)
  def put(k: String, v: String): Data226 = copy(meta = meta.updated(k, v))
  def merge(other: Data226): Data226 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data226 {
  given Ordering[Data226] = Ordering.by(_.id)
  def empty: Data226 = Data226(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data226 =
    Data226(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data226] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
