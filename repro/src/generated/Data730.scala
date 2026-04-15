package generated

final case class Data730(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data730 = copy(name = name.toUpperCase)
  def scale(k: Double): Data730 = copy(value = value * k)
  def addTag(t: String): Data730 = copy(tags = t :: tags)
  def put(k: String, v: String): Data730 = copy(meta = meta.updated(k, v))
  def merge(other: Data730): Data730 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data730 {
  given Ordering[Data730] = Ordering.by(_.id)
  def empty: Data730 = Data730(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data730 =
    Data730(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data730] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
