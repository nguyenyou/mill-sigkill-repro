package generated

final case class Data1418(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1418 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1418 = copy(value = value * k)
  def addTag(t: String): Data1418 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1418 = copy(meta = meta.updated(k, v))
  def merge(other: Data1418): Data1418 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1418 {
  given Ordering[Data1418] = Ordering.by(_.id)
  def empty: Data1418 = Data1418(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1418 =
    Data1418(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1418] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
