package generated

final case class Data789(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data789 = copy(name = name.toUpperCase)
  def scale(k: Double): Data789 = copy(value = value * k)
  def addTag(t: String): Data789 = copy(tags = t :: tags)
  def put(k: String, v: String): Data789 = copy(meta = meta.updated(k, v))
  def merge(other: Data789): Data789 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data789 {
  given Ordering[Data789] = Ordering.by(_.id)
  def empty: Data789 = Data789(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data789 =
    Data789(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data789] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
