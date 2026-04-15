package generated

final case class Data1280(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1280 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1280 = copy(value = value * k)
  def addTag(t: String): Data1280 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1280 = copy(meta = meta.updated(k, v))
  def merge(other: Data1280): Data1280 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1280 {
  given Ordering[Data1280] = Ordering.by(_.id)
  def empty: Data1280 = Data1280(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1280 =
    Data1280(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1280] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
