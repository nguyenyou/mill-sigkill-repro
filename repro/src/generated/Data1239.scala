package generated

final case class Data1239(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1239 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1239 = copy(value = value * k)
  def addTag(t: String): Data1239 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1239 = copy(meta = meta.updated(k, v))
  def merge(other: Data1239): Data1239 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1239 {
  given Ordering[Data1239] = Ordering.by(_.id)
  def empty: Data1239 = Data1239(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1239 =
    Data1239(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1239] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
