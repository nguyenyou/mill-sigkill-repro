package generated

final case class Data1428(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1428 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1428 = copy(value = value * k)
  def addTag(t: String): Data1428 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1428 = copy(meta = meta.updated(k, v))
  def merge(other: Data1428): Data1428 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1428 {
  given Ordering[Data1428] = Ordering.by(_.id)
  def empty: Data1428 = Data1428(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1428 =
    Data1428(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1428] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
