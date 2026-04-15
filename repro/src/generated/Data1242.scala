package generated

final case class Data1242(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1242 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1242 = copy(value = value * k)
  def addTag(t: String): Data1242 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1242 = copy(meta = meta.updated(k, v))
  def merge(other: Data1242): Data1242 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1242 {
  given Ordering[Data1242] = Ordering.by(_.id)
  def empty: Data1242 = Data1242(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1242 =
    Data1242(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1242] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
